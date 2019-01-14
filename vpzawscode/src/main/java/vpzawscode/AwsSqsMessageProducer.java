
package vpzawscode;

import java.util.List;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.DeleteQueueRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.ListQueuesRequest;
import software.amazon.awssdk.services.sqs.model.ListQueuesResponse;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequestEntry;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SqsException;

public class AwsSqsMessageProducer {

	public static void main(String[] args) {

		SqsClient sqsclient = SqsClient.builder().region(Region.AP_SOUTH_1).build();
		CreateQueueRequest request = CreateQueueRequest.builder().queueName("vpzmsgq").build();
		sqsclient.createQueue(request);

		GetQueueUrlResponse response = sqsclient.getQueueUrl(GetQueueUrlRequest.builder().queueName("vpzmsgq").build());
		String qurl = response.queueUrl();
		ListQueuesRequest listQueuesRequest = ListQueuesRequest.builder().build();
		ListQueuesResponse listQueuesResponse = sqsclient.listQueues(listQueuesRequest);

		for (String str : listQueuesResponse.queueUrls())
			System.out.println("msgqs: " + str);

		sqsclient.sendMessage(SendMessageRequest.builder().queueUrl(qurl).messageBody("Hello Vinod").build());
		sqsclient.sendMessage(SendMessageRequest.builder().queueUrl(qurl).messageBody("{\"name:\":\"vinod pawar\"}")
				.delaySeconds(4).build());
		SendMessageBatchRequest batchRequest = SendMessageBatchRequest.builder().queueUrl(qurl)
				.entries(SendMessageBatchRequestEntry.builder().id("message01").messageBody("message01data").build(),
						SendMessageBatchRequestEntry.builder().id("message02").messageBody("message02data").build())
				.build();
		sqsclient.sendMessageBatch(batchRequest);
		ReceiveMessageRequest messageRequest = ReceiveMessageRequest.builder().queueUrl(qurl).maxNumberOfMessages(4)
				.build();
		List<Message> messages = sqsclient.receiveMessage(messageRequest).messages();
		for (Message message : messages) {
			System.out.println(message.messageId() + ":" + message.body());

			DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder().queueUrl(qurl)
					.receiptHandle(message.receiptHandle()).build();
			sqsclient.deleteMessage(deleteMessageRequest);
		}

		DeleteQueueRequest deleteQueueRequest = DeleteQueueRequest.builder().queueUrl(qurl).build();
		sqsclient.deleteQueue(deleteQueueRequest);
		System.out.println("=================================================");
		try {
			ReceiveMessageRequest messageRequest2 = ReceiveMessageRequest.builder().queueUrl(qurl)
					.maxNumberOfMessages(4).build();
			List<Message> messages2 = sqsclient.receiveMessage(messageRequest2).messages();
			for (Message message : messages2)
				System.out.println(message.messageId() + ":" + message.body());
		} catch (SqsException ex) {
			System.out.println("AWS Error - SQS queue not available");
		}

	}
}

/*
 * class SQSExample {
 * 
 * public static void main(String[] args) { String queueName = "queue" +
 * System.currentTimeMillis(); SqsClient sqsClient =
 * SqsClient.builder().region(Region.US_WEST_2) .build();
 * 
 * System.out.println("\nCreate Queue"); CreateQueueRequest createQueueRequest =
 * CreateQueueRequest.builder() .queueName(queueName).build();
 * sqsClient.createQueue(createQueueRequest);
 * 
 * System.out.println("\nGet queue url"); GetQueueUrlResponse
 * getQueueUrlResponse = sqsClient.getQueueUrl(
 * GetQueueUrlRequest.builder().queueName(queueName).build()); String queueUrl =
 * getQueueUrlResponse.queueUrl(); System.out.println(queueUrl);
 * 
 * System.out.println("\nList Queues"); String prefix = "que"; ListQueuesRequest
 * listQueuesRequest = ListQueuesRequest.builder()
 * .queueNamePrefix(prefix).build(); ListQueuesResponse listQueuesResponse =
 * sqsClient .listQueues(listQueuesRequest); for (String url :
 * listQueuesResponse.queueUrls()) { System.out.println(url); }
 * 
 * // List queues with filters String name_prefix = "queue"; ListQueuesRequest
 * filterListRequest = ListQueuesRequest.builder()
 * .queueNamePrefix(name_prefix).build();
 * 
 * ListQueuesResponse listQueuesFilteredResponse = sqsClient
 * .listQueues(filterListRequest); System.out.println("Queue URLs with prefix: "
 * + name_prefix); for (String url : listQueuesFilteredResponse.queueUrls()) {
 * System.out.println(url); }
 * 
 * System.out.println("\nSend message");
 * sqsClient.sendMessage(SendMessageRequest.builder().queueUrl(queueUrl)
 * .messageBody("Hello world!").delaySeconds(10).build());
 * 
 * System.out.println("\nSend multiple messages"); SendMessageBatchRequest
 * sendMessageBatchRequest = SendMessageBatchRequest
 * .builder().queueUrl(queueUrl) .entries(
 * SendMessageBatchRequestEntry.builder().id("id1")
 * .messageBody("Hello from msg 1").build(),
 * SendMessageBatchRequestEntry.builder().id("id2")
 * .messageBody("msg 2").delaySeconds(10).build()) .build();
 * sqsClient.sendMessageBatch(sendMessageBatchRequest);
 * 
 * System.out.println("\nReceive messages"); ReceiveMessageRequest
 * receiveMessageRequest = ReceiveMessageRequest
 * .builder().queueUrl(queueUrl).maxNumberOfMessages(5).build(); List<Message>
 * messages = sqsClient.receiveMessage(receiveMessageRequest) .messages();
 * 
 * System.out.println("\nChange Message Visibility"); for (Message message :
 * messages) { ChangeMessageVisibilityRequest req =
 * ChangeMessageVisibilityRequest .builder().queueUrl(queueUrl)
 * .receiptHandle(message.receiptHandle()) .visibilityTimeout(100).build();
 * sqsClient.changeMessageVisibility(req); }
 * 
 * System.out.println("\nDelete Messages"); for (Message message : messages) {
 * DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest
 * .builder().queueUrl(queueUrl)
 * .receiptHandle(message.receiptHandle()).build();
 * sqsClient.deleteMessage(deleteMessageRequest); }
 * 
 * System.out.println("\nDelete Queue"); DeleteQueueRequest deleteQueueRequest =
 * DeleteQueueRequest.builder() .queueUrl(queueUrl).build();
 * sqsClient.deleteQueue(deleteQueueRequest); } }
 */
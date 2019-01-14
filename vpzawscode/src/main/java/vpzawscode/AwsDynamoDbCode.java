package vpzawscode;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;
import software.amazon.awssdk.services.dynamodb.model.DeleteTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;

public class AwsDynamoDbCode {

	public static void main(String[] args) {

		DynamoDbClient ddb = DynamoDbClient.create();
		String table_name = "vpztable";
		CreateTableRequest createTableRequest = CreateTableRequest.builder()
				.attributeDefinitions(AttributeDefinition.builder().attributeName("Name")
						.attributeType(ScalarAttributeType.S).build())
				.keySchema(KeySchemaElement.builder().attributeName("Name").keyType(KeyType.HASH).build())
				.provisionedThroughput(ProvisionedThroughput.builder().readCapacityUnits(new Long(10))
						.writeCapacityUnits(new Long(10)).build())
				.tableName(table_name).build();

		try {
			CreateTableResponse response = ddb.createTable(createTableRequest);
			System.out.println(response.tableDescription().tableName());
		} catch (DynamoDbException e) {
			System.err.println("Table not created: " + e.getMessage());
		}

		DeleteTableRequest deleteTableRequest = DeleteTableRequest.builder().tableName(table_name).build();
		try {
			ddb.deleteTable(deleteTableRequest);
		} catch (DynamoDbException e) {
			System.err.println("Deletion error: " + e.getMessage());
		}

	}
}
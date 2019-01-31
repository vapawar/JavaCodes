package vpzawscode;
import java.io.File;
import java.util.List;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketConfiguration;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Object;

public class AwsS3StorageCode {

	public static void main(String[] args) {

		Region region = Region.AP_SOUTH_1;
		S3Client client = S3Client.builder().region(region).build();

		CreateBucketRequest createBucketRequest = CreateBucketRequest.builder().bucket("vpz-aws-storage")
				.createBucketConfiguration(CreateBucketConfiguration.builder().locationConstraint(region.id()).build())
				.build();
		try {
			client.createBucket(createBucketRequest);
		} catch (Exception e) {
			System.out.println("Bucket creation failed");
		}

		ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
		ListBucketsResponse listBucketsResponse = client.listBuckets(listBucketsRequest);
		listBucketsResponse.buckets().stream().forEach(x -> System.out.println("bucket details: " + x));

		client.putObject(PutObjectRequest.builder().bucket("vpz-aws-storage").key("testData").build(),
				RequestBody.fromFile(new File("D:\\ak.txt")));

		ListObjectsV2Request request = ListObjectsV2Request.builder().bucket("vpz-aws-storage").build();

		// ListObjectsV2Iterable res = client.listObjectsV2Paginator(request);
		// for (ListObjectsV2Response str : res) {
		// System.out.println("Stored Pbject: " + str.contents());
		// }

		List<S3Object> data = client.listObjectsV2(request).contents();
		data.forEach(x -> System.out.println("s3 object: " + x));
		client.deleteObject(DeleteObjectRequest.builder().bucket("vpz-aws-storage").key("testData").build());

		System.out.println("-------------------------------------------------------------------------------");
		List<S3Object> data2 = client.listObjectsV2(request).contents();
		data.forEach(x -> System.out.println("s3 object: " + x));
		client.deleteBucket(DeleteBucketRequest.builder().bucket("vpz-aws-storage").build());

		System.out.println("============================================================");
		client.listBuckets().buckets().forEach(x -> System.out.println("==================" + x));
		System.out.println("============================================================");
	}
}

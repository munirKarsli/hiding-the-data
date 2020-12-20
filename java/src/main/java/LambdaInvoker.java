import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;

class LambdaInvoker {

    public static void invoke() {

        Regions region = Regions.fromName("eu-west-1");

        BasicAWSCredentials credentials = new
                BasicAWSCredentials("Access key", "Secret Key");


        AWSLambdaClientBuilder builder = AWSLambdaClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region);


        AWSLambda client = builder.build();

        InvokeRequest req = new InvokeRequest()
                .withFunctionName("req"); // optional

        InvokeResult result = client.invoke(req);

        String response = new String(result.getPayload().array());

        System.out.println(response);

    }

    public static void main(String[] args){

        System.out.println("Hello Go Lambda");

        invoke();

    }



}






// main.go
package main

import (
	"github.com/aws/aws-lambda-go/lambda"
	"io/ioutil"
	"log"
	"os"
	"net/http"
)

func hello() (string, error) {


	resp, err := http.Get(os.Getenv("link"))
	if err != nil {
		return "error: "+ os.Getenv("link"),nil
	   
	}
 //We Read the response body on the line below.
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		return "error: "+ os.Getenv("link"),nil;
	}
 //Convert the body to type string
	sb := string(body)
	log.Printf(sb)



	return  sb, nil
}

func main() {
	// Make the handler available for Remote Procedure Call by AWS Lambda
	lambda.Start(hello)
}

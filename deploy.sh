REGION=$1
PROFILE=$2
DEPLOYMENT_BUCKET_NAME=$3
STACK_NAME=$4

./gradlew build

sam package --template-file sam.yaml --output-template-file packaged.yaml --s3-bucket $DEPLOYMENT_BUCKET_NAME

aws --region us-east-1 cloudformation deploy \
--template-file packaged.yaml \
--stack-name $STACK_NAME \
--capabilities CAPABILITY_IAM

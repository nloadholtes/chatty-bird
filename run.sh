source $1
docker build -t chatty .
docker run -it --rm -e CONSUMER_KEY="$CONSUMER_KEY" \
       -e CONSUMER_SECRET="$CONSUMER_SECRET" \
       -e ACCESS_TOKEN="$ACCESS_TOKEN" \
       -e ACCESS_TOKEN_SECRET="$ACCESS_TOKEN_SECRET" \
       -e WAIT_TIME="$3" \
	-v $PWD:/data \
       chatty $2

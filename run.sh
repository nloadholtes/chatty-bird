source env.vars
docker build -t chatty .
docker run -it --rm -e CONSUMER_KEY=$CONSUMER_KEY \
       -e CONSUMER_SECRET=$COMSUMER_SECRET \
       -e ACCESS_TOKEN=$ACCESS_TOKEN \
       -e ACCESS_TOKEN_SECRET=$ACCESS_TOKEN_SECRET \
       chatty

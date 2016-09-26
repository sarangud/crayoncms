FROM grails3:3.1.10
MAINTAINER Gogula Rajaprabhu <rgogulakrishnan@gmail.com>

# Copy App files
COPY . /app

# Switch to work dir. We have multi project setup for now
# which will be removed later
WORKDIR /app/crayoncms

# Set Default Behavior
ENTRYPOINT ["grails"]
CMD ["run"]
docker build -f Dockerfile -t platform-zuul-ui .
docker images
docker run -p 8087:8087 platform-zuul-ui
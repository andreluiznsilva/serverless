FROM node:7-alpine
ADD ./index.js /app/index.js
ADD ./package.json /app/package.json
RUN cd /app && npm install
EXPOSE 8080
WORKDIR /app
CMD  node /app/index
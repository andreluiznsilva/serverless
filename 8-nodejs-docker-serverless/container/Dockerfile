FROM node:7-alpine
ADD ./app.js /app/app.js
ADD ./package.json /app/package.json
RUN cd /app && npm install
WORKDIR /app
CMD  node /app/app
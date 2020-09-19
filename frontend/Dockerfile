FROM node:alpine
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY package.json /usr/src/app
RUN yarn
COPY . /usr/src/app
EXPOSE 3000
CMD yarn start


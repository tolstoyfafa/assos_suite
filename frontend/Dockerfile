FROM node:12.18.4-alpine
RUN mkdir -p /usr/src/app
ENV PATH /app/node_modules/.bin:$PATH
WORKDIR /usr/src/app
COPY package.json /usr/src/app
COPY yarn.lock /usr/src/app
RUN yarn
COPY . /usr/src/app
EXPOSE 3000
CMD yarn start


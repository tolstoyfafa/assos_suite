FROM node:alpine AS build
WORKDIR /app
COPY . /app
ENV PATH /app/node_modules/.bin:$PATH
RUN yarn
RUN yarn build

FROM nginx:alpine
COPY --from=build /app/build /usr/share/nginx/html
# RUN rm /etc/nginx/conf.d/default.conf
# COPY config/nginx/default.conf /etc/nginx/conf.d
# --------- /only for those using react router ----------
# expose port 80 to the outer world
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

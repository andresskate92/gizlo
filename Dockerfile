FROM node:10-alphine as appGizlo
RUN mkdir -p /appGizlo
WORKDIR /appGizlo
COPY package.json /appGizlo
RUN npm install
COPY . /appGizlo
RUN npm run build --prod

FROM nginx:1.20.1-alpine


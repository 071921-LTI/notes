## How to `Dockerize` an Angular app 🦸

1. Open an angular application in VScode.

2. Create a new file (directly in the Angular application's directory) called `Dockerfile`
    > The file must be titled `Dockerfile` *exactly*, with no extensions.
3. Create a distribution directory which will hold all of the files to be deployed on nginx. Inside your application, run the following command:
    > `ng build`
    
4. Within this file, write the following code:
```sh
# FROM specifies the base image (also called the parent image).  In this case we will use Ubuntu OS
FROM nginx:1.17.1-alpine
# Copy all files from the dist directory to the directory where ngix hosts the files to serve at a specified port
COPY dist/[app-name] /usr/share/nginx/html
```

5. Build an image from the Dockerfile with the following command: <br>
    > `docker build -t [app-name]:latest .`
6. Create a command by running the imamge on port 80 with the following command. <br>
    > `docker run -p 80:80 -d --name [container-name]  [app-name]:latest`
<br>

<hr>

<br>

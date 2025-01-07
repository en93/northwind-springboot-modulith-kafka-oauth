import SwaggerClient from 'swagger-client';
import YAML from 'js-yaml';


let client = null;

//todo update name
const swaggerClient = async () => {
  if (!client) {
    try {
    // Await the initialization of Swagger Client
      const apiSpec = await fetch('/api.yaml');
      const apiSpecJson = await apiSpec.text();
      const swaggerDef = YAML.load(apiSpecJson);
      client = await SwaggerClient(
        {
          spec: swaggerDef,
          url: 'http://localhost:8080/api',
          clientConfiguration: {
            basePath: '/api',
          },
          requestInterceptor: (req) => {
            console.log('API Request:', {
              url: req.url,
              method: req.method,
              headers: req.headers,
              params: req.query
            });
            // req.credentials = 'no-cors';
            return req;
          },
          responseInterceptor: (res) => {
            console.log('API Response:', {
              status: res.status,
              url: res.url,
              data: res.body
            });
            return res;
        }
      });  
    } catch (err) {
      console.error('Error initializing Swagger Client', err);
      throw err;
    }
  }
  return client;
};

export {swaggerClient};
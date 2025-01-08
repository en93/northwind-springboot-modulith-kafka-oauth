import { swaggerClient } from "@/swagger/swaggerClient";

export const productsService = {
    async searchProducts(params) {
        const client = await swaggerClient(); 
        return await client.apis.Product.getProducts(params);
    }
}
import { swaggerClient } from "@/swagger/swaggerClient";

export const productsService = {
    async searchProducts(params) {
        const client = await swaggerClient(); 
        console.log(client);
        let p2 = {
            productKey: 'sample1',
            searchName: 'sample2'
        }
        console.log(client.apis.Product);
        let res = await client.apis.Product.getProducts(p2);
        console.log(res)
        return res;
    }
}
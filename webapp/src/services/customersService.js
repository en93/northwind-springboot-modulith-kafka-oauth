import { swaggerClient } from "@/swagger/swaggerClient";

export const customersService = {
    async searchCustomers(params) {
        const client = await swaggerClient(); 
        return await client.apis.Customer.getCustomers(params);
    }
}
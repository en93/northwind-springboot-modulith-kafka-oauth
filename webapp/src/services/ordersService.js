import { swaggerClient } from "@/swagger/swaggerClient";

export const ordersService = {
    async searchOrders(params) {
        const client = await swaggerClient(); 
        return await client.apis.Order.getOrders(params);
    }
}
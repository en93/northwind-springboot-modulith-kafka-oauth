import { swaggerClient } from "@/swagger/swaggerClient";

export const supplierService = {
    async searchSuppliers(params) {
        const client = await swaggerClient(); 
        return await client.apis.Supplier.getSuppliers(params);
    }
}
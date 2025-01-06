import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
// import { GlobalErrorBoundary } from '@/components/error-boundaries/GlobalErrorBoundary';
// import { SearchErrorBoundary } from '@/components/error-boundaries/SearchErrorBoundary';
// import { SearchProvider } from '@/contexts/SearchContext';
import { Header } from '@/components/layout/Header';
import { ProductsTab } from '@/components/tabs/ProductsTab';
import { OrdersTab } from '@/components/tabs/OrdersTab';
import { SuppliersTab } from '@/components/tabs/SuppliersTab';
import { CustomersTab } from '@/components/tabs/CustomersTab';
import { API_CONFIG } from '@/utils/constants';
import '@/styles/globals.css'

const App = () => {
  return (
    // <GlobalErrorBoundary>
    //   <SearchProvider>
        <div className="container mx-auto p-4">
          <Header />
          
          <Tabs defaultValue={API_CONFIG.ENDPOINTS.PRODUCTS} className="w-full">
            <TabsList className="w-full justify-start">
              <TabsTrigger value={API_CONFIG.ENDPOINTS.PRODUCTS}>
                Products
              </TabsTrigger>
              <TabsTrigger value={API_CONFIG.ENDPOINTS.ORDERS}>
                Orders
              </TabsTrigger>
              <TabsTrigger value={API_CONFIG.ENDPOINTS.SUPPLIERS}>
                Suppliers
              </TabsTrigger>
              <TabsTrigger value={API_CONFIG.ENDPOINTS.CUSTOMERS}>
                Customers
              </TabsTrigger>
            </TabsList>

            {/* <SearchErrorBoundary> */}
            <TabsContent value={API_CONFIG.ENDPOINTS.PRODUCTS}>
                <ProductsTab />
              </TabsContent>
              <TabsContent value={API_CONFIG.ENDPOINTS.ORDERS}>
                <OrdersTab />
              </TabsContent>
              <TabsContent value={API_CONFIG.ENDPOINTS.SUPPLIERS}>
                <SuppliersTab />
              </TabsContent>
              <TabsContent value={API_CONFIG.ENDPOINTS.CUSTOMERS}>
                <CustomersTab />
              </TabsContent>
            {/* </SearchErrorBoundary> */}
          </Tabs>
        </div>
    //   </SearchProvider>
    // </GlobalErrorBoundary>
  );
};

export default App;

// import React, { useState } from 'react';
// import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
// import { Input } from '@/components/ui/input';
// import { Button } from '@/components/ui/button';
// import { Card, CardContent } from '@/components/ui/card';
// import { Search } from 'lucide-react';
// import '@/styles/globals.css'

// // SearchForm component that will be reused across tabs
// const SearchForm = ({ onSearch, placeholder }) => {
//   const [searchQuery, setSearchQuery] = useState('');

//   const handleSubmit = (e) => {
//     e.preventDefault();
//     onSearch(searchQuery);
//   };

//   return (
//     <form onSubmit={handleSubmit} className="flex gap-2 mb-4">
//       <Input
//         type="text"
//         placeholder={placeholder}
//         value={searchQuery}
//         onChange={(e) => setSearchQuery(e.target.value)}
//         className="flex-1"
//       />
//       <Button type="submit">
//         <Search className="w-4 h-4 mr-2" />
//         Search
//       </Button>
//     </form>
//   );
// };

// // Results list component that will display search results
// const ResultsList = ({ items }) => {
//   if (!items?.length) {
//     return (
//       <div className="text-center text-gray-500 py-8">
//         No results found
//       </div>
//     );
//   }

//   return (
//     <div className="space-y-2">
//       {items.map((item) => (
//         <Card key={item.id}>
//           <CardContent className="p-4">
//             <h3 className="font-medium">{item.name || item.companyName}</h3>
//             {item.description && <p className="text-sm text-gray-600">{item.description}</p>}
//             {item.contactName && <p className="text-sm text-gray-600">Contact: {item.contactName}</p>}
//           </CardContent>
//         </Card>
//       ))}
//     </div>
//   );
// };

// // Tab content components
// const TabContent = ({ title, searchPlaceholder, onSearch, results }) => (
//   <div>
//     <SearchForm onSearch={onSearch} placeholder={searchPlaceholder} />
//     <ResultsList items={results} />
//   </div>
// );

// const App = () => {
//   // State for each tab's search results
//   const [productResults, setProductResults] = useState([]);
//   const [orderResults, setOrderResults] = useState([]);
//   const [supplierResults, setSupplierResults] = useState([]);
//   const [customerResults, setCustomerResults] = useState([]);

//   // Search handlers for each tab
//   const handleProductSearch = async (query) => {
//     try {
//       const response = await fetch(`/api/products?search=${query}`);
//       const data = await response.json();
//       setProductResults(data);
//     } catch (error) {
//       console.error('Error searching products:', error);
//     }
//   };

//   const handleOrderSearch = async (query) => {
//     try {
//       const response = await fetch(`/api/orders?search=${query}`);
//       const data = await response.json();
//       setOrderResults(data);
//     } catch (error) {
//       console.error('Error searching orders:', error);
//     }
//   };

//   const handleSupplierSearch = async (query) => {
//     try {
//       const response = await fetch(`/api/suppliers?search=${query}`);
//       const data = await response.json();
//       setSupplierResults(data);
//     } catch (error) {
//       console.error('Error searching suppliers:', error);
//     }
//   };

//   const handleCustomerSearch = async (query) => {
//     try {
//       const response = await fetch(`/api/customers?search=${query}`);
//       const data = await response.json();
//       setCustomerResults(data);
//     } catch (error) {
//       console.error('Error searching customers:', error);
//     }
//   };

//   return (
//     <div className="container mx-auto p-4">
//       <h1 className="text-2xl font-bold text-center mb-6">Northwind-Webapp</h1>
      
//       <Tabs defaultValue="products" className="w-full">
//         <TabsList className="w-full justify-start">
//           <TabsTrigger value="products">Products</TabsTrigger>
//           <TabsTrigger value="orders">Orders</TabsTrigger>
//           <TabsTrigger value="suppliers">Suppliers</TabsTrigger>
//           <TabsTrigger value="customers">Customers</TabsTrigger>
//         </TabsList>

//         <TabsContent value="products">
//           <TabContent
//             title="Products"
//             searchPlaceholder="Search products..."
//             onSearch={handleProductSearch}
//             results={productResults}
//           />
//         </TabsContent>

//         <TabsContent value="orders">
//           <TabContent
//             title="Orders"
//             searchPlaceholder="Search orders..."
//             onSearch={handleOrderSearch}
//             results={orderResults}
//           />
//         </TabsContent>

//         <TabsContent value="suppliers">
//           <TabContent
//             title="Suppliers"
//             searchPlaceholder="Search suppliers..."
//             onSearch={handleSupplierSearch}
//             results={supplierResults}
//           />
//         </TabsContent>

//         <TabsContent value="customers">
//           <TabContent
//             title="Customers"
//             searchPlaceholder="Search customers..."
//             onSearch={handleCustomerSearch}
//             results={customerResults}
//           />
//         </TabsContent>
//       </Tabs>
//     </div>
//   );
// };

// export default App;
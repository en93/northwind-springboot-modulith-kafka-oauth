import { Card, CardContent } from '@/components/ui/card';

export const ProductResultsList = ({ items }) => {
  if (!items?.length) {
    return (
      <div className="text-center text-gray-500 py-8">
        No results found
      </div>
    );
  }

  return (
    <div className="space-y-2">
      {items.map((product) => (
        <Card key={product.productKey}>
          <CardContent className="p-4">
            <h3 className="font-medium">{product.name}</h3>
            {product.productKey && (
              <p className="text-sm text-gray-600">Key: {product.productKey}</p>
            )}
            {product.description && (
              <p className="text-sm text-gray-600">Description: {product.description}</p>
            )}
            {product.supplierId && (
              <p className="text-sm text-gray-600">SupplierId: {product.supplierId}</p>
            )}
            {product?.category?.categoryName && (
              <p className="text-sm text-gray-600">Category: {product.category.categoryName}</p>
            )}
            {product.unit && (
              <p className="text-sm text-gray-600">Unit: {product.unit}</p>
            )}
            {product.price && (
              <p className="text-sm text-gray-600">Price: ${product.price}</p>
            )}
          </CardContent>
        </Card>
      ))}
    </div>
  );
};
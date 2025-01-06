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
      {items.map((item) => (
        <Card key={item.id}>
          <CardContent className="p-4">
            <h3 className="font-medium">{item.name || item.companyName}</h3>
            {item.description && (
              <p className="text-sm text-gray-600">{item.description}</p>
            )}
            {item.contactName && (
              <p className="text-sm text-gray-600">Contact: {item.contactName}</p>
            )}
          </CardContent>
        </Card>
      ))}
    </div>
  );
};
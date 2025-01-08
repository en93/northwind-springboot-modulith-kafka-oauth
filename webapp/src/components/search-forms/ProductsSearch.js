import { useState } from 'react';
import { Input } from '@/components/ui/input';
import { Button } from '@/components/ui/button';
import { Label } from '@/components/ui/label';
import { Search } from 'lucide-react';

export const ProductSearchForm = ({ onSearch, placeholder }) => {
  const [productKey, setProductkey] = useState('');
  const [productName, setProductName] = useState('');
//   const [localError, setLocalError] = useState(null);
//   const { lastSearches } = useSearchContext();

  const handleSubmit = (e) => {
    e.preventDefault();
    // const validation = validateSearchQuery(searchQuery);
    
    // if (!validation.isValid) {
    //   setLocalError(validation.error);
    //   return;
    // }
    
    // setLocalError(null);
    onSearch({productKey,productName});
  };

  return (
    <div className="space-y-2">
      <form onSubmit={handleSubmit} className="flex gap-2">
        <Label htmlFor="productKey">Key</Label>
        <Input
          id="productKey"
          type="text"
          placeholder={placeholder}
          value={productKey}
          onChange={(e) => {
            setProductkey(e.target.value);
            // setLocalError(null);
          }}
          className="flex-1"
        />
        <Label htmlFor="productName">Name</Label>
        <Input
          id="productName"
          type="text"
          placeholder={placeholder}
          value={productName}
          onChange={(e) => {
            setProductName(e.target.value);
            // setLocalError(null);
          }}
          className="flex-1"
        />
        <Button type="submit">
          <Search className="w-4 h-4 mr-2" />
          Search
        </Button>
      </form>
      {/* {localError && (
        <div className="text-red-500 text-sm">{localError}</div>
      )} */}
    </div>
  );
};
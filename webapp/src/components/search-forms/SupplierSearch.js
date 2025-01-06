import { useState } from 'react';
import { Input } from '@/components/ui/input';
import { Button } from '@/components/ui/button';
import { Search } from 'lucide-react';

export const SupplierSearchForm = ({ onSearch, placeholder }) => {
  const [searchQuery, setSearchQuery] = useState('');
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
    onSearch(searchQuery);
  };

  return (
    <div className="space-y-2">
      <form onSubmit={handleSubmit} className="flex gap-2">
        <Input
          type="text"
          placeholder={placeholder}
          value={searchQuery}
          onChange={(e) => {
            setSearchQuery(e.target.value);
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
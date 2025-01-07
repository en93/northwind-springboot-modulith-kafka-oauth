import { useState } from 'react';
// import { api } from '@/services/api';
import { productsService } from '@/services/productsService';

export const useSearch = (endpoint) => {
  const [results, setResults] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);
//   const { addSearch } = useSearchContext();

  const handleSearch = async (query) => {
    // const validation = validateSearchQuery(query);
    // if (!validation.isValid) {
    //   setError(validation.error);
    //   return;
    // }

    setIsLoading(true);
    setError(null);
    
    try {
      const data = await productsService.searchProducts(null); //api.search(endpoint, query);
      setResults(data);
    } catch (err) {
      setError(err.message);
      setResults([]);
    } finally {
      setIsLoading(false);
    }
  };

  return { results, isLoading, error, handleSearch };
};
import { useState } from 'react';

export const useSearch = (searchApi) => {
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
      const data = await searchApi(query);
      setResults(data.body);
    } catch (err) {
      setError(err.message);
      setResults([]);
    } finally {
      setIsLoading(false);
    }
  };

  return { results, isLoading, error, handleSearch };
};
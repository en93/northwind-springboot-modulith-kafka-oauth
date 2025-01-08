import { ProductSearchForm } from '@/components/search-forms/ProductsSearch';
import { ProductResultsList } from '@/components/results-lists/ProductResultsList';
import { LoadingSpinner } from '@/components/layout/LoadingSpinner';
import { useSearch } from '@/hooks/useSearch';
import { API_CONFIG } from '@/utils/constants';
import { customersService } from '@/services/customersService';

export const CustomersTab = () => {
  const { results, isLoading, error, handleSearch } = useSearch(customersService.getCustomers);
  return (
    <div className="space-y-4">
      <ProductSearchForm
        onSearch={handleSearch}
        placeholder="Search products..."
      />
      {isLoading && <LoadingSpinner />}
      {error && <div className="text-red-500">{error}</div>}
      {!isLoading && !error && <ProductResultsList items={results} />}
    </div>
  );
};
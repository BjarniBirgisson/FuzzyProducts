export interface Product {
  productId: string;
  name: string;
  category: string;
  description: string;
  price: string;
  imageUrl: string;
}

// Get all products from the API endpoint
export async function getProducts(): Promise<Product[]> {
  const headers: Headers = new Headers();
  headers.set('Content-Type', 'application/json');
  headers.set('Accept', 'application/json');
  headers.set('X-Custom-Header', 'CustomValue');

  const request: RequestInfo = new Request('http://localhost:8080/products', {
    method: 'GET',
    headers: headers,
  });

  const res = await fetch(request);
  const res_1 = await res.json();
  return res_1 as Product[];
}

// Search products for a specific query string through the API endpoint
export async function search(query: string): Promise<Product[]> {
  const headers: Headers = new Headers();
  headers.set('Content-Type', 'application/json');
  headers.set('Accept', 'application/json');
  headers.set('X-Custom-Header', 'CustomValue');

  const request: RequestInfo = new Request(
    'http://localhost:8080/search/' + query,
    {
      method: 'GET',
      headers: headers,
    }
  );

  const res = await fetch(request);
  const res_1 = await res.json();
  return res_1 as Product[];
}

// Fetch a specific product with id from the API endpoint
export async function getProduct(productId: string): Promise<Product[]> {
  const headers: Headers = new Headers();
  headers.set('Content-Type', 'application/json');
  headers.set('Accept', 'application/json');
  headers.set('X-Custom-Header', 'CustomValue');

  const request: RequestInfo = new Request(
    'http://localhost:8080/products/' + productId,
    {
      method: 'GET',
      headers: headers,
    }
  );

  const res = await fetch(request);
  const res_1 = await res.json();
  return res_1 as Product[];
}


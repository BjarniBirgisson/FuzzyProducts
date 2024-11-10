interface Product {
  productId: string;
  name: string;
  category: string;
  description: string;
  price: string;
  imageUrl: string;
}

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

export function trigger() {
  const result = document.getElementById('result');
  if (!result) {
    throw new Error('No element with ID `result`');
  }

  getProducts().then((products) => {
    result.innerHTML = products.map((p) => p.name).toString();
  });
}

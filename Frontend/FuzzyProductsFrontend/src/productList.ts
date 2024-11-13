import { getProducts } from './integration';
import { search } from './integration';
import { Product } from './integration';

export async function setProductList() {
  const result = document.getElementById('product-list-container');
  if (!result) {
    throw new Error('No element with ID `result`');
  }

  getProducts().then(products => 
    result.innerHTML = products.map(p => getProductCard(p)).join(""));
}

export function getProductCard(p: Product): String {
  var card: String = '';
  card += '<div class="product-card" id="' + p.productId + '">';
  card += '<h3 class="product-title">' + p.name + '</h3>';
  card += '<p class="product-category">' + p.category + '</p>';
  card += '<p class="product-price">' + p.price + '</p>';
  card += '</div>';

  return card;
}

export async function searchProducts() {
  const result = document.getElementById('product-list-container');
  const q = document.getElementById('search') as HTMLInputElement;
  if (!result) {
    throw new Error('No element with ID `result`');
  }
  if (!q) {
    throw new Error('No element with ID `search`');
  }
  
  if (isBlank(q.value)) {
    getProducts().then(products => 
      result.innerHTML = products.map(p => getProductCard(p)).join(""));
  } else {
    search(q.value).then(products => 
      result.innerHTML = products.map(p => getProductCard(p)).join(""));

  }
}

function isBlank(str: string) {
    return (!str || /^\s*$/.test(str));
}
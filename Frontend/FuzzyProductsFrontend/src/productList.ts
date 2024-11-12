import { getProducts } from './integration';
import { Product } from './integration';

export async function setProductList() {
  const result = document.getElementById('product-list-container');
  if (!result) {
    throw new Error('No element with ID `result`');
  }

  getProducts().then(products => 
    result.innerHTML = products.map(p => getProductCard(p)).toString());
}

export function getProductCard(p: Product): String {
  var card: String = '';
  card += '<div class="product-card">';
  card += '<h3 class="product-title">' + p.name + '</h3>';
  card += '<p class="product-description">' + p.description + '</p>';
  card += '<p class="product-price">' + p.price + '</p>';
  card += '</div>';

  return card;
}

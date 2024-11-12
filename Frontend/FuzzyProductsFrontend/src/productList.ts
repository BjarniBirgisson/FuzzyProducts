import { getProducts } from './search.ts';
import { Product } from './search.ts';

export function setProductList() {
  const result = document.getElementById('product-list-container');
  if (!result) {
    throw new Error('No element with ID `result`');
  }

  let products: Product[] = getProducts();
  let cards: String[] = [];
  for (let i = 0; i < products.length; i++) {
    cards.push(getProductCard(products[i]));
  }

  result.innerHTML = cards.toString();
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

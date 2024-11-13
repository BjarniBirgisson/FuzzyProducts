import { getProducts } from './integration';
import { search } from './integration';
import { Product } from './integration';
import { viewProduct } from './productDetail';

// Fetch the entire product List and populate the elements. Also add event listener to each item
export async function setProductList() {
  const result = document.getElementById('product-list-container');
  if (!result) {
    throw new Error('No element with ID `result`');
  }

  await getProducts().then(products => 
    result.innerHTML = products.map(p => getProductCard(p)).join(""));
	
	var elements = document.getElementsByClassName("product-card");
	Array.from(elements).forEach(function(element) {
      element.addEventListener('click', () => viewProduct(element.id));
    });
}

// Search for products, will fetch all products if the search query is empty
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
    await getProducts().then(products => 
      result.innerHTML = products.map(p => getProductCard(p)).join(""));
  } else {
    await search(q.value).then(products => 
      result.innerHTML = products.map(p => getProductCard(p)).join(""));
  }
  	var elements = document.getElementsByClassName("product-card");
	Array.from(elements).forEach(function(element) {
      element.addEventListener('click', () => viewProduct(element.id));
    });
}

// Setting up the Product Card HTML code
export function getProductCard(p: Product): string {
  var card: string = '';
  card += '<div class="product-card flex-card" id="' + p.productId + '">';
  card += '<div class="product-title flex-div">' + p.name + '</div>';
  card += '<div class="product-category flex-div">' + p.category + '</div>';
  card += '<div class="product-price flex-div">' + p.price + '</div>';
  card += '</div>';

  return card;
}

// Check if a string is blank or not
function isBlank(str: string) {
    return (!str || /^\s*$/.test(str));
}
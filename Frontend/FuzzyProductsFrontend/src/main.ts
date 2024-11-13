import './style.css';
import { setProductList } from './productList';
import { searchProducts } from './productList';

// Setup initial HTML
document.querySelector<HTMLDivElement>('#app')!.innerHTML = `
  <div>
    <h3>Fuzzy Products Frontend</h3>
    <div class="card">
      <label for="search">Search Products</label>
      <input type="search" id="search" name="search" placeholder="Search Products By Name"> 
    </div>
    <div id="product-list-container"></div>
	<div id="product-detail-container" class="product-detail-container" style="display: none;"><div class="product-detail-header"><span id="close-details" class="close" onclick="closeDetails()">×</span><h2>sked</h2></div><div class="product-detail-body flex-card"><div class="flex-div"><img src="" alternative="NO IMAGE AVAILABLE" width="100" height="100"> </div><div class="flex-div"><p>0</p><p>Matsked</p><p>10</p></div></div></div>
  </div>
`;

// Function for closing the Product Details popup window
export function closeDetails() {
  const detail = document.getElementById('product-detail-container');
  const close = document.getElementById('close-details');
  if (!detail || !close) {
    throw new Error('No element with ID `product-detail-container` or close-details');
  }

  if (event.target == close) {
    detail.style.display = "none";
  }
}

// Add listener on window load to fetch initial Product List and bind the even listener to search box
window.addEventListener('load', () => {

	setProductList();
 
	const search_field = document.getElementById('search');
	search_field.addEventListener('input', () => searchProducts());
});

window.addEventListener('click', () => closeDetails());




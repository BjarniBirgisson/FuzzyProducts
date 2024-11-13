import './style.css';
import { trigger } from './integration';
import { setProductList } from './productList';
import { searchProducts } from './productList';

document.querySelector<HTMLDivElement>('#app')!.innerHTML = `
  <div>
    <h3>Fuzzy Products Frontend</h3>
    <div class="card">
      <label for="search">Search Products</label>
      <input type="search" id="search" name="search" placeholder="Search Products By Name"> 
    </div>
    <button id="trigger" type="button">Trigger</button>
    <div id="product-list-container"></div>
  </div>
`;

const element = document.getElementById('trigger');
if (!element) {
  throw new Error('No element with ID `result`');
} else {
  element.addEventListener('click', () => searchProducts());
  setProductList();
}


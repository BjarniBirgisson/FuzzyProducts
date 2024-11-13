import { getProduct } from './integration';
import { Product } from './integration';


// Fetch a specific product and display it in the popup
export async function viewProduct(id: string) {
  const detail = document.getElementById('product-detail-container');
  if (!detail) {
    throw new Error('No element with ID `product-detail-container`');
  }
  
    getProduct(id).then(products => 
      detail.innerHTML = products.map(p => getProductDetail(p)).join(""));
	detail.style.display = "block";
}

// Populate the Product Detail HTML
export function getProductDetail(p: Product): string {
  var details: string = '';
  details += '<div class="product-detail-header">';
  details += '<span id="close-details" class="close">&times;</span>';
  details += '<h2>' + p.name + '</h2></div>'
  details += '<div class="product-detail-body flex-card">';
  details += '<div class="flex-div">';
  details += '<img src="'+p.imageUrl+'" alternative="NO IMAGE AVAILABLE" width="100" height="100"> </div>';
  details += '<div class="flex-div">';
	details += '<p>Product ID: '+p.productId+'</p>';
		details += '<p>Kategori: '+p.category+'</p>';
	details += '<p>Beskrivning: '+p.description+'</p>';
	details += '<p>Pris: '+p.price+'</p>';
	details += '</div></div></div>';

  return details;
}


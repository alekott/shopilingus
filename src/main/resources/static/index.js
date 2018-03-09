const HOST = 'http://localhost:8080';

function initFilters(filters) {
  const { shops, shopTypes} = filters;
  initShopFilters(shops);
  initShopsTypesFilters(shopTypes);
}

function initShopFilters(shops) {
  const shopsFilterSelect = document.querySelector('.shop-select');

  shops.forEach(shop => {
    const shopElement = document.createElement('option');
    shopElement.setAttribute('value', shop.id);
    shopElement.innerHTML = shop.name;
    shopsFilterSelect.appendChild(shopElement);
    });
}

function initShopsTypesFilters(shopTypes) {
  const shopsTypesFilterSelect = document.querySelector('.shoptypes-checkBox');

  shopTypes.forEach(shopType => {
    const shopElementDiv = document.createElement('div');
    const shopElement = document.createElement('input');
    shopElement.setAttribute('type', 'checkBox');
    shopElement.setAttribute('value', shopType);
    const shopTypeValue = document.createElement('label');
    shopTypeValue.appendChild(shopElement);
    shopTypeValue.innerHTML += shopType;
    shopElementDiv.appendChild(shopTypeValue);
    shopsTypesFilterSelect.appendChild(shopElementDiv);
  });
}

function getFilteringParams() {
  const productNamePhrase = document.querySelector('.product-name').value;
  const shopNamePhrase = document.querySelector('.shop-name').value;
  const minProductPrice = document.querySelector('.min-price').value;
  const maxProductPrice= document.querySelector('.max-price').value;
  const typesShop = document.querySelectorAll('.shoptypes-checkBox input');
  const shopTypes = Array.from(typesShop)
    .filter(checkbox => checkbox.checked)
    .map(checkbox => checkbox.value);

  const result = {
    productNamePhrase,
    shopNamePhrase,
    minProductPrice,
    maxProductPrice,
    shopTypes
  };
  return result;
}

const createQueryParamsString = object => Object.keys(object)
  .filter(key => object[key] !== undefined)
  .filter(key => String(object[key]) !== '')
  .map(key => `${key}=${object[key]}`)
  .join('&');

const onLoadShops = function() {
  const filterParams = getFilteringParams();
  fetchFilteredShops(filterParams).then(showShops);
}

const filterButton = document.querySelector('.submit-button');
filterButton.addEventListener('click', onLoadShops);

const fetchFilteredShops = function(filterParams){
 const queryString = createQueryParamsString(filterParams);
 return fetch(HOST + '/shops' + '?' + queryString)
  .then(response => response.json())
  .catch(error => console.log(error));
}

const filtersPromise = fetch(HOST + '/filters')
  .then(response => response.json())
  .then(filters => initFilters(filters))
  .catch(error => console.log(error));

const currentYear = new Date().getFullYear();
currentYearElement = document.querySelector(".current-year");
currentYearElement.innerHTML = currentYear;

function createShopElement(shop){
  const shopElement = document.createElement('div');
  shopElement.innerHTML = shop.name;
  shopElement.setAttribute('data-id', shop.id)
  shopElement.addEventListener('click', showAllProducts)
  const shopElementFloor = document.createElement('span');
  shopElementFloor.innerHTML = shop.location.floor;
  shopElement.appendChild(shopElementFloor);
  const detailsContainer = document.createElement('div');
  detailsContainer.setAttribute('class', 'details');
  shopElement.appendChild(detailsContainer);
  return shopElement;
}

function showShops(shops) {
  const container = document.querySelector(".shop-elements");
  shops
    .map(createShopElement)
    .forEach(shopElement => container.appendChild(shopElement));
    console.log(shops);
}

function showAllProducts(event) {
  const id = event.target.getAttribute('data-id');
  fetchShopDetails(id).then(products =>
    products.forEach(product => {
      const productElement = document.createElement('div');
      const productName = document.createElement('span');
      productName.innerHTML = product.name;
      productElement.appendChild(productName);
      event.target.querySelector('.details').appendChild(productElement);
      }));;
}

function fetchShopDetails(shopId) {
  return fetch(HOST + '/shops/' + shopId + '/products')
    .then(response => response.json())
    .catch(error => console.log(error));
}



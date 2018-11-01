$('.test').on('click', function () {



    let productSeller = $('<div class="product-seller"><p>Виробник</p><p>Назва продукту</p></div>');
    let productDescription = $('<div class="product-descrition"></div>')
        .append(productSeller)
        .append('<p>Name</p>')
        .append('<p>Phone number</p>');
    let productContainer = $('<div class="product-container"></div>')
        .append('<div class="product-photo"></div>')
        .append(productDescription)
        .append('<div class="product-price"><p>4654</p></div>');

    $('.product-cart').append(productContainer);
});
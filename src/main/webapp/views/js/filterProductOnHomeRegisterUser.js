// $(document).ready(function() {
// //     $(window).keydown(function(event){
// //         if(event.keyCode == 13) {
// //             event.preventDefault();
// //             return true;
// //         }
// //     });
// // });
let filter;

let hotLot = $('.hot_lot');
$('.comm-product-main').on('click', function () {
    let elem = $(this).find('a');
    // console.log('asd' === 'asd');
    getOnControllerFromFilter(elem);

});


$('.sub-category-title').find('a').on('click', function () {
    $.ajax({
        url:'http://localhost:8080/filter/allLot',
        success: function (result) {
            parseSetFromController(result,"false");
        }
    })
});


$('.sub-category').on('click','.comm-product',function () {
        let elem = $(this).find('a');
        getOnControllerFromFilter(elem, "true");
});

$('.sub-category').on('click','.sub-product',function () {
    let el = $(this).find('a');
    let text = el.text();
    let message = text.indexOf("(");
    let nameSubProduct = text.substring(0, message);
    // console.log(nameSubProduct);
    $.ajax({
        url: 'http://localhost:8080/sub/'+nameSubProduct,
        success: function (result) {
            filter = document.getElementsByClassName('change');
            hotLot.empty();
            el.toggleClass('change');
            $.each(result, function (a,b) {
                parseListOfLotFromControllerOnView(b);
            });
        if (hotLot.has('div').length===0) {
                // console.log("ok");
                hotLot.append('<h2 class="text-no-div">По Вашому запиту немає жодного результату</h2>')
            }
            // console.log(hotLot.has('div').length);
            let jsonFilter = criteriaJsonFilter(filter);
            sendPostJsonCriteria(jsonFilter);
        }
    });

});

$('.type-lot li').on('click',function () {
    // let find = $(this).text();
    $(this).toggleClass('change');
    filter = document.getElementsByClassName('change');
    let jsonFilter = criteriaJsonFilter(filter);
    sendPostJsonCriteria(jsonFilter);

});

$('#region-lot').on('change',function () {
    // console.log($(this).find('option:selected').text());
    if($(this).find('option:selected').val()!=='0'){
        $('.div-region-lot').addClass('change');
    }
    else if ($(this).find('option:selected').val() === '0') {
        $('.div-region-lot').removeClass('change');
    }
    filter = document.getElementsByClassName('change');
    let jsonFilter = criteriaJsonFilter(filter);
    sendPostJsonCriteria(jsonFilter);
});

$('.filter-price-btn').on('click',function () {
    let priceFrom = $('.filter-price-from').val();
    let priceTo = $('.filter-price-to').val();
    if (priceFrom !=='' || priceTo!==''){
        $('.div-input').addClass('change');
    }else {
        $('.div-input').removeClass('change')
    }
    filter = document.getElementsByClassName('change')
    let jsonFilter = criteriaJsonFilter(filter);
    sendPostJsonCriteria(jsonFilter);
});

$('.select-data-start').on('change',function () {
    let $select = $('.select-data-start option:selected');
    // console.log($select.text());
    if ($select.val()!=='0') {
        $('.filter-data-start').addClass('change');


    }else{
        $('.filter-data-start').removeClass('change');
    }
    filter = document.getElementsByClassName('change');
    let jsonFilter = criteriaJsonFilter(filter);
    sendPostJsonCriteria(jsonFilter);
});

$('.select-data-end').on('change',function () {
    let $select = $('.select-data-end option:selected');
    // console.log($select.text());
    if ($select.val()!=='0') {
        $('.filter-data-end').addClass('change');

        // console.log(asd);
    }else{
        $('.filter-data-end').removeClass('change');
        //
    }
    filter = document.getElementsByClassName('change');
    let jsonFilter = criteriaJsonFilter(filter);
    sendPostJsonCriteria(jsonFilter);
});





//--------------------------- functions  -------------------------//

function getOnControllerFromFilter(elem) {
    let text = elem.text();
    let message = text.indexOf("(");
    let nameCommProduct = text.substring(0, message);
    $.ajax({
        url: 'http://localhost:8080/filter/comm/'+nameCommProduct,
        success: function (result) {

            parseSetFromController(result, "true");
        }
    });
}

function parseSetFromController(result, boolean) {
    /*if boolean is 'true':
    *       this need for return class = "sub-product"
    *       else return class = "comm-product"
    *       */

    hotLot.empty();
    $('.sub-category').empty();
    $.each(result, function(a, b) {
        if (a === 0) {
            $.each(b, function (x, y) {
                if (boolean === "true") {
                    $('.sub-category').append('<li class="sub-product"><a href="#">'+x+'('+y+')</a></li>')
                }else if (boolean === "false") {
                    $('.sub-category').append('<li class="comm-product"><a href="#">'+x+'('+y+')</a></li>')
                }
            })
        }
        else if (a>0 && b.idProduct!=null) {
            parseListOfLotFromControllerOnView(b);
        }
    });
}

function parseListOfLotFromControllerOnView(b) {
    $('.hot_lot').append('<div class="hot_lot_wrapper">' +
        '<div class="cont_img">' +
        '<a href="lot/'+b.idProduct+'" class="get-id"><img' +
        ' src="../img/product_Img/'+b.imgLink+'" height="200" width="200"/></a></div>' +
        '<div class="container">' +
        '<h2 class="cont_titel"><b>' +
        '<p>'+b.nameProduct +" "+b.modelProduct+'</p>' +
        '</b></h2>' +
        '<p class="text-end">завершення :</p>' +
        '<div class="cont_timer">' +
        '<p>'+b.dataEndLot+'</p>' +
        '</div>' +
        '<h4 class="cont_price">Ціна : <span>'+b.currentPrice +' грн.</span></h4>' +
        '</div>' +
        '</div>')
}
// function createJSON() {
//     jsonObj = [];
//     $("input[class=email]").each(function() {
//
//         var id = $(this).attr("title");
//         var email = $(this).val();
//
//         item = {}
//         item ["title"] = id;
//         item ["email"] = email;
//
//         jsonObj.push(item);
//     });
function criteriaJsonFilter(HTMLCollection) {
    let jsonObj = [];
    let sub = {};
    let dataStart = {};
    let dataEnd = {};
    let priceFrom = {};
    let priceTo = {};
    let region = {};
    let typeSell = {};
    let arraySub = [];
    let arrayTypeLot = [];
    let count=0;
    /*
    *    static values:
    *       comparison -> we get from enums in Comparison.class !!!    *
    *       field -> equal field in entity, where we find
    *       exmpl: sub['nameSubCategory'] -> value in array is field in Condition.class (for JSON serialization)
    * */
    for (let i = 0; i < HTMLCollection.length; i++) {
        let filterElement = HTMLCollection[i];
        // console.log(filterElement + " >> " + filterElement.className);
        console.log(HTMLCollection);
        if (filterElement.tagName === 'A') {
            let text = filterElement.innerHTML;
            ++count;
            for (let j = 0; j < count; j++) {
                let message = text.indexOf("(");
                // arraySub[i]=text.substring(0, message);

                sub['nameSubCategory'] = text.substring(0, message);
                sub['comparison'] = "eq";
                sub['field'] = "nameSubCategory";
                console.log(sub);
            }

        }
        else if (filterElement.tagName === 'LI') {
            let nodes = Array.prototype.slice.call(HTMLCollection);
            let liRef = document.getElementsByClassName('type-lot-li change')[0];
            let indexOf = nodes.indexOf( liRef );

            arrayTypeLot[i-indexOf]=filterElement.title;

            typeSell['typeSell'] = arrayTypeLot;
            typeSell['comparison'] = "eq";
            typeSell['field'] = "typeSell";
        }
        else if (filterElement.tagName === 'DIV') {
            if (filterElement.className === 'filter-data-start change') {

                dataStart['dataStartLot'] = document.querySelector('.select-data-start').selectedOptions[0].value;// value -> hour
                dataStart['comparison'] = "gt";
                dataStart['field'] = "dataStartLot";
            }
            else if (filterElement.className === 'filter-data-end change') {

                dataEnd['dataEndLot'] = document.querySelector('.select-data-end').selectedOptions[0].value; // value -> hour
                dataEnd['comparison'] = "lt";
                dataEnd['field'] = "dataEndLot";
            }
            else if (filterElement.className === 'div-region-lot change') {
                region['regionLot'] = document.querySelector('#region-lot').selectedOptions[0].innerHTML;
                region['comparison'] = "eq";
                region['field'] = "regionLot";
            }
            else if (filterElement.className === 'div-input change') {

                let listChild = filterElement.children;
                for (let j = 0; j < listChild.length; j++) {
                    if (listChild[j].className === 'filter-price-from' && listChild[j].value!=="") {
                        priceFrom['priceFrom'] = listChild[j].value;
                        priceFrom['comparison'] = 'gt';
                        priceFrom['field'] = "priceFrom";
                    }
                    if (listChild[j].className === 'filter-price-to' && listChild[j].value!=="") {
                        priceTo['priceTo'] = listChild[j].value;
                        priceTo['comparison'] = "lt";
                        priceTo['field'] = "priceTo";
                    }
                }
            }
        }
    }

/*
*   push to jsonObj only filling object
*
*   */
    if (Object.keys(sub).length>0) {
        jsonObj.push(sub)
    }
    if (Object.keys(dataStart).length>0) {
        jsonObj.push(dataStart)
    }
    if (Object.keys(dataEnd).length>0) {
        jsonObj.push(dataEnd)
    }
    if (Object.keys(region).length>0) {
        jsonObj.push(region)
    }
    if (Object.keys(typeSell).length>0) {
        jsonObj.push(typeSell)
    }
    if (Object.keys(priceFrom).length>0) {
        jsonObj.push(priceFrom)
    }
    if (Object.keys(priceTo).length>0) {
        jsonObj.push(priceTo)
    }
   /*
   * create association array
   * */
    let s = JSON.stringify(jsonObj);
    console.log(s);
    return s;
}


function sendPostJsonCriteria(JSON) {
    /*
    * send to RestControllerFilterProduct    *
    * */
    $.ajax({
        url: 'http://localhost:8080/filter/criteria/',
        type:"post",
        contentType: "application/json;charset=utf-8",
        data: JSON, //Stringified Json Object
        dataType: 'json',
        success:function (result) {
            console.log("ok");
        }
    });
}


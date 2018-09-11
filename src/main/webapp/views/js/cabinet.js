
    let optionList = $('.options-list li');
    let optionListShow = $('.option-list-show div');
    optionList.on('click', function () {
        for (let i = 0; i < optionList.length; i++) {
            optionList[i].style.borderBottom = 1 +'px solid gray';
        }
        $(this).css('border-bottom', 'none');

        for (let j = 0; j < optionListShow.length; j++){
            optionListShow[j].classList.add('hidden')

        }
        if ($(this).attr('id') === 'sell') {
            $('.sell').toggleClass('hidden');
        } else if ($(this).attr('id') === 'buy') {
            $('.buy').toggleClass('hidden');
        } else if ($(this).attr('id') === 'history') {
            $('.history').toggleClass('hidden');
        }else if ($(this).attr('id') === 'settings') {
            $('.settings').toggleClass('hidden');
        }else if ($(this).attr('id') === 'balans') {
            $('.balans').toggleClass('hidden');
        }else if ($(this).attr('id') === 'mesagges') {
            $('.mesagges').toggleClass('hidden');
        }
       /* if ($(this).attr('id') === 'sell') {
            $('.sell').css('display', 'block');
        } else if ($(this).attr('id') === 'buy') {
            $('.buy').css('display', 'block');
        } else if ($(this).attr('id') === 'history') {
            $('.history').css('display', 'block');
        }else if ($(this).attr('id') === 'settings') {
            $('.settings').css('display', 'block');
        }else if ($(this).attr('id') === 'balans') {
            $('.balans').css('display', 'block');
        }else if ($(this).attr('id') === 'mesagges') {
            $('.mesagges').css('display', 'block');
        }*/
    });

    optionList.first().css('border-bottom', 'none');


const observer = new IntersectionObserver((entries) => {
    entries.forEach((entry) => {
        console.log(entry)
        if (entry.isIntersecting) {
            entry.target.classList.add('show');
        } else {
            entry.target.classList.remove('show');
        }
    });
});

const headerElements = document.querySelectorAll('.header');
headerElements.forEach((el) => observer.observe(el));

const CardSectionElements = document.querySelectorAll('.card');
CardSectionElements.forEach((el) => observer.observe(el));

const serviceElements = document.querySelectorAll('.service');
serviceElements.forEach((el) => observer.observe(el));

const WhatWeDoElements = document.querySelectorAll('.WhatWeDo');
WhatWeDoElements.forEach((el) => observer.observe(el));

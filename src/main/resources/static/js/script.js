"use strict";

//toggles visibility of edit form on team-posts
function toggleEdit(postId) {
    let post = document.getElementById("post-" + postId);
    let editButton = post.querySelector(".edit-button");
    let titleInput = post.querySelector(".title-input");
    let contentTextarea = post.querySelector(".content-textarea");
    let saveButton = post.querySelector(".save-button");
    let postTitle = post.querySelector(".post-title");
    let postContent = post.querySelector(".post-content");
    let titleLabel = post.querySelector(".title-label")
    let contentLabel = post.querySelector(".content-label")

    if (!post.dataset.editing) {
        post.dataset.editing = true;
        titleInput.style.display = "block";
        contentTextarea.style.display = "block";
        editButton.style.display = "none";
        saveButton.style.display = "block";
        postTitle.style.display = "none";
        postContent.style.display = "none";
        titleLabel.style.display = "block";
        contentLabel.style.display = "block";
    } else {
        post.dataset.editing = false;
        titleInput.style.display = "none";
        contentTextarea.style.display = "none";
        editButton.style.display = "inline-block";
        saveButton.style.display = "none";
        postTitle.style.display = "block";
        postContent.style.display = "block";
        titleLabel.style.display = "none";
        contentLabel.style.display = "none";
    }
}
//Toggle comment reply form on team-posts
document.querySelectorAll('.reply-button').forEach(function(button) {
    button.addEventListener('click', function(e) {
        var commentForm = e.target.nextElementSibling;
        commentForm.style.display = (commentForm.style.display === 'none' ? 'block' : 'none');
    });
});
//hides request button on teams index page if there is already a pending request
$(document).ready(function() {
    if ($('.cancel-request').length) {
        $('.request-button').css("display", "none");
        $('.request-form').css("display", "none");
    }
});
//for sidebar on team posts page
function openSidebar() {
    document.getElementById("mySidebar").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
    document.querySelector('.main-container').classList.remove('sidebar-closed');
}

function closeSidebar() {
    document.getElementById("mySidebar").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.querySelector('.main-container').classList.add('sidebar-closed');
}

function showPopup(userId) {
    let popup = $("#popup-" + userId);
    popup.find("#userId").val(userId);
    popup.show();
}

function hidePopup(userId) {
    let popup = $("#popup-" + userId);
    popup.hide();
}
//register page password visible
function togglePasswordVisibility(fieldId) {
    let passwordInput = document.getElementById(fieldId);
    let passwordVisibilityButton = document.querySelector("#" + fieldId + " + .btn");
    if (passwordInput.type === "password") {
        passwordInput.type = "text";
        passwordVisibilityButton.innerHTML = '<i class="fa-regular fa-eye"></i>';
    } else {
        passwordInput.type = "password";
        passwordVisibilityButton.innerHTML = '<i class="fa-regular fa-eye-slash"></i>';
    }
}
//navbar controls
const hbBtn = document.getElementById('hb-btn');
const navContainer = document.getElementById('nav');

hbBtn.addEventListener('click', () => {
    navContainer.classList.toggle('active');
});
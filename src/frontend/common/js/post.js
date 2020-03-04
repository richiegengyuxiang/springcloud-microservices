$(".top-nav").load("../components/topNav.html")
let pageURL = $(location).attr('href');
let id = pageURL.split("/").pop();
loadLeftSidebarNav()

$(".content-container").append(`
    <h1>Manage data in Docker</h1>
    <div>By default all files created inside a container are stored on a writable container layer. This means that:
        The data doesn’t persist when that container no longer exists, and it can be difficult to get the data out of the container if another process needs it.
        A container’s writable layer is tightly coupled to the host machine where the container is running. You can’t easily move the data somewhere else.
        Writing into a container’s writable layer requires a storage driver to manage the filesystem. The storage driver provides a union filesystem, using the Linux kernel. This extra abstraction reduces performance as compared to using data volumes, which write directly to the host filesystem.
        Docker has two options for containers to store files in the host machine, so that the files are persisted even after the container stops: volumes, and bind mounts. If you’re running Docker on Linux you can also use a tmpfs mount. If you’re running Docker on Windows you can also use a named pipe.
        Keep reading for more information about these two ways of persisting data.
    </div>
    <div>By default all files created inside a container are stored on a writable container layer. This means that:
        The data doesn’t persist when that container no longer exists, and it can be difficult to get the data out of the container if another process needs it.
        A container’s writable layer is tightly coupled to the host machine where the container is running. You can’t easily move the data somewhere else.
        Writing into a container’s writable layer requires a storage driver to manage the filesystem. The storage driver provides a union filesystem, using the Linux kernel. This extra abstraction reduces performance as compared to using data volumes, which write directly to the host filesystem.
        Docker has two options for containers to store files in the host machine, so that the files are persisted even after the container stops: volumes, and bind mounts. If you’re running Docker on Linux you can also use a tmpfs mount. If you’re running Docker on Windows you can also use a named pipe.
        Keep reading for more information about these two ways of persisting data.
    </div>
`)

$(".right-sidebar-nav").append(`
    <ul class="nav">
        <li><a href="/edit/${id}">Edit this page</a></li>
        <li><a>Dark mode</a></li>
    </ul>
`)
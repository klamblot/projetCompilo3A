	extrn lirent:proc, ecrent:proc
	extrn ecrbool:proc
	extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE
debut :
	STARUPCODE
	mov bp,sp
	sub sp,14
	push 10
	push 10
	push 2
	pop bx
	pop ax
	cwd
	idiv bx
	push ax
	pop bx
	pop ax
	add ax,bx
	push ax
	push 5
	pop bx
	pop ax
	cwd
	idiv bx
	push ax
	pop ax
	mov word ptr[bp-2],ax
	push word ptr[bp-2]
	push 3
	push word ptr[bp-2]
	pop bx
	pop ax
	imul bx
	push ax
	pop bx
	pop ax
	add ax,bx
	push ax
	push 10
	pop bx
	pop ax
	sub ax,bx
	push ax
	pop ax
	mov word ptr[bp-4],ax
	push -1
	push -1
	pop bx
	pop ax
	or ax,bx
	push ax
	pop ax
	mov word ptr[bp-12],ax
	push word ptr[bp-2]
	push word ptr[bp-4]
	push 4
	pop bx
	pop ax
	add ax,bx
	push ax
	pop bx
	pop ax
	cmp ax,bx
	jg $+6
	push -1
	jump $+4
	push 0
	pop ax
	mov word ptr[bp-14],ax
	nop
	exitcode
	end debut

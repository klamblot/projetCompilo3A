	extrn lirent:proc, ecrent:proc
	extrn ecrbool:proc
	extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE
debut :
	STARUPCODE
	mov bp,sp
	sub sp,6
.DATA
	mess0 DB "x=$"
.CODE
	lea dx,mess0
	push dx
	call ecrch
	lea dx,[bp-2]
	push dx
	call lirent
	call ligsuiv
	nop
	exitcode
	end debut

.class public LHelloWorld;
.super Ljava/lang/Object;
.method public static main([Ljava/lang/String;)V
    .registers 4
	.parameter
    .prologue
	#��ָ��
    nop
    nop
    nop
    nop
	#���ݶ���ָ��
	const/16 v0, 0x8
	const/4 v1, 0x5
	const/4 v2, 0x3
	#���ݲ���ָ��
	move v1, v2
	#�������ָ��
	new-array v0, v0, [I
	array-length v1, v0
	#ʵ������ָ��
	new-instance v1, Ljava/lang/StringBuilder;
	#��������ָ��
	invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V
	#��תָ��
	if-nez v0, :cond_0
	goto :goto_0
	:cond_0
	#����ת��ָ��
	int-to-float v2, v2
	#��������ָ��
	add-float v2, v2, v2
	#�Ƚ�ָ��
	cmpl-float v0, v2, v2
	#�ֶβ���ָ��
	sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;
	const-string v1, "Hello World" #�����ַ���
	#��������ָ��
	invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
	#����ָ��
	:goto_0
    return-void
.end method
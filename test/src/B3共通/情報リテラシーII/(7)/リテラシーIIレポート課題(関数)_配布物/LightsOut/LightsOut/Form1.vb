Public Class Form1

    '===========================================================================================================
    '利用者がリセットボタンを押すと、Button1～Button25の表面の色を、ランダムに10個だけ赤色に、残りを青色にする。 
    '===========================================================================================================
    Private Sub Button26_Click(sender As System.Object, e As System.EventArgs) Handles Button26.Click
        'シャッフルする配列 
        Dim ary As Integer() = New Integer() {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

        'Fisher-Yatesアルゴリズムでシャッフルする 
        Dim rng As New System.Random()
        Dim n As Integer = ary.Length
        While n > 1
            n -= 1
            Dim k As Integer = rng.Next(n + 1)
            Dim tmp As Integer = ary(k)
            ary(k) = ary(n)
            ary(n) = tmp
        End While

        light(Button1, ary(0))
        light(Button2, ary(1))
        light(Button3, ary(2))
        light(Button4, ary(3))
        light(Button5, ary(4))
        light(Button6, ary(5))
        light(Button7, ary(6))
        light(Button8, ary(7))
        light(Button9, ary(8))
        light(Button10, ary(9))
        light(Button11, ary(10))
        light(Button12, ary(11))
        light(Button13, ary(12))
        light(Button14, ary(13))
        light(Button15, ary(14))
        light(Button16, ary(15))
        light(Button17, ary(16))
        light(Button18, ary(17))
        light(Button19, ary(18))
        light(Button20, ary(19))
        light(Button21, ary(20))
        light(Button22, ary(21))
        light(Button23, ary(22))
        light(Button24, ary(23))
        light(Button25, ary(24))
    End Sub

    '==============================================================================
    '引数numが1なら、引数o(Button1～15)の表面の色を赤色に、それ以外なら青色にする。 
    '==============================================================================
    Public Sub light(o As Object, num As Integer)
        If num = 1 Then
            o.backcolor = Color.Red
        Else
            o.backcolor = Color.Cyan
        End If
    End Sub
End Class

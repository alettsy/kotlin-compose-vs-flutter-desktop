import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:http/http.dart' as http;
import 'package:infinite_list_bloc/posts/view/posts_list.dart';

import '../bloc/post_bloc.dart';

class PostsPage extends StatelessWidget {
  const PostsPage({super.key});

/*
fun primes(n: Int): MutableList<Int> {
    val li = mutableListOf<Int>()
    for (num in 2..n) {
        if ((2 until num).none{ num % it == 0 })
            li.add(num)
    }
    return li
}

 */

  List<int> primes(int n) {
    var li = <int>[];
    for (int num = 2; num < n; num++) {
      var add = true;

      for (int j = 2; j < num; j++) {
        if (num % j == 0) {
          add = false;
          break;
        }
      }

      if (add) {
        li.add(num);
      }
    }

    return li;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Posts')),
      body:  Row(
        children: [
          SizedBox(
            height: MediaQuery.of(context).size.height,
            width: MediaQuery.of(context).size.width / 2,
            child: BlocProvider(
              create: (_) => PostBloc(httpClient: http.Client())..add(PostFetched()),
              child: const PostsList(),
            ),
          ),
          ElevatedButton(
              onPressed: () {
                var stopwatch = Stopwatch()..start();
                var x = primes(200000);
                print(x.last);
                stopwatch.stop();
                print('Time taken(ms): ${stopwatch.elapsedMilliseconds}\n');
              },
              child: const Text("Primes")
          )
        ],
      ),
    );
  }
}

%%%-------------------------------------------------------------------
%%% @author grzegorz
%%% @copyright (C) 2016, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 03. cze 2016 20:08
%%%-------------------------------------------------------------------
-module(mecz).
-author("grzegorz").

-export([kopnij/1, stop/1], start/2).

kopnij(Kraj) ->
  Kraj ! kopnij.

stop(Kraj) ->
  Kraj ! stop.

start(Kraj, Partner) ->
  receive
    kopnij ->
      generated_value = random:uniform(1),
      if
        generated_value == 1 ->
          Partner ! bramka;
        true ->
          Partner ! obroniona
      end;
    obroniona ->
      io:format("Obronione~n");
    bramka ->
      io:format("Gol~n");
    stop ->
      io:format("Zatrzymano~n");
    
end.





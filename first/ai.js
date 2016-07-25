registerPlugin({
	name: 'UmaruAI',
	version: '0.01',
	description: 'Custom chat AI',
	author: 'Bloc97',
	vars: [
	]
	
	},
	
	function(sinusbot, config){
		
	var isprocessing=false;
		
		function compare(string, substr){
			return (string.search(substr) != -1);
		}
			
			
		function contains(string, array){
			return (array.indexOf(string) != -1);
		}
		
		function parsedict(string, array){
			for (var i=0; i<array.length; i++){
				if (compare(string, array[i])){
					return true;
				}
			}
			return false;
		}
		
		function toBoolean(num){
			return (num == 1);
		}
		
		
		function sleep(milliseconds) {
		var start = new Date().getTime();
		for (var i = 0; i < 1e7; i++) {
			if ((new Date().getTime() - start) > milliseconds){
			break;
			}
		}
		}
		
			
			
		function response(speakername){
			
			var yes_good = ["Yes.","Yes","Yea","Yep","Yeah","YEAH"];
			var yes_bad = ["yes","yea","yeah","Yes"];			
			var yes_angry = ["","YEA","Yep","YEaH","YEs","YES!!","YES! OMG...","OMG!"];	
			
			var no_good = ["No","Not at all.","No.","No"];

			
			
			var response_greeting = ["hi","Hey","Hey, "+speakername+"-san.","Hi.","hello","Hello","Hello.","Hello, "+speakername+"-san."];
			

			
			var response_question_personal_good = ["alright","i'm alright","I'm alright","fine","Fine","I'm fine","I'm feeling fine","I'm feeling fine","great","Great","I feel great","I'm feeling great"];
			var response_question_personal_bad = ["...","i feel down","i feel bad","not very well","could be better","i'm not happy","i'm unhappy right now","I had a rough day","my day was bad...","ugh","sigh"];
			var response_question_personal_angry = ["..!","!!","i'm angry","I'M ANGRY","I'm mad","I'm MAD","it's SO annoying","it's SO ANNOYING"];
			
			var response_thanks_good = [".","!",", thanks.",", thanks",", thanks!",". Thanks",", thanks, "+speakername+"-san!",". Thanks, "+speakername+"-san.",". Thanks!","! You?",", and you?",". What about you?",", and you "+speakername+"-san?",". What about you "+speakername+"-san?","! Thanks! ^_^"," ^_^"];
			var response_thanks_bad = [".","...","... -_-","... but thanks.",", but thanks...",", but thanks anyway...","... but thank you."];
			var response_thanks_angry = [".","!","!!","!!!",", grr...","... >.<"," >_<"];
			
			var suffix="";
			
			var message = response_question_personal_good[Math.floor(Math.random()*response_question_personal_good.length)];
			var isSuffix = toBoolean(Math.round(Math.random()));
			
			if (isSuffix){
				var suffix = response_thanks_good[Math.floor(Math.random()*response_thanks_good.length)];
			}
			return message+suffix;
		}
		
		function response_yes(speakername){
			
			var response_yes_good = ["Yes, ","Yea, ","Yep, ","Yeah, ","Yes. ","Yea ","Yep ","Yeah. "];
			var response_yes_bad = ["yes ","yes, ","yea ","yeah ","Yes ","yeah, ","Yes, "];
			var response_yes_angry = ["YEA ","YEA, ","Yep ","Yep. ","YEaH ","YEs ","YES!! ","OMG YES! ","OMG! "];

			var message = response(speakername);
			
			var prefix = response_yes_good[Math.floor(Math.random()*response_yes_good.length)];
			
			return prefix+message;
			
		}
		
		function response_no(speakername){
			
			var response_no_good = ["No, ","Not at all, ","No. ","No, "];
			var response_no_bad = ["no... ","not really, ","no. ","No... "];
			var response_no_angry = ["NO! ","NO, ","no. ","No. "];
			
			var message = response(speakername);
			
			var prefix = response_no_good[Math.floor(Math.random()*response_no_good.length)];
			
			return prefix+message;
			
		}
			
		
		sinusbot.on("chat", function(chatev){
			
			var msg = chatev.msg;
			var msgL = chatev.msg.toLowerCase();
			var mode = chatev.mode;
			var speaker = chatev.clientId;
			var speakername = chatev.clientNick;
			var listner = getBotId();
			var listnername = getNick();
			
			var greeting = ["hi","hello","hey","welcome","greetings","howdy","bonjour"," day ","morning","afternoon","evening","what's up","to see you","long time","a while","seeing you"];
			var goodbye = ["bye","see you","see ya","night"];
			
			var question_general_personal = ["how are you"];
			var question_general_other = ["how is your","how are your"];
			var question_boolean_personal = ["are you"];
			var question_boolean_other = ["is your","are your"];
			
			var question_general = ["how","who","where","when","why","what","which"]
			
			var personal_verbs = ["doing","feeling"];
			
			var good = [" good","great","fine","splend","alright","finest"," best","better","well"," ok"];
			var bad = ["bad","angr","down","poor","mad","worse","worst","uneas","worr","ugly","stupid"];
			
			var canSpeak=false;
			var speakmsg="";
			
			//28ms per character reading
			//93ms per character typing
			//800ms reaction time
			
			if (listnername != speakername && mode == 2 && isprocessing==false) {
				
				
				if (compare(msgL,"umaru")){
					
					if (parsedict(msgL,question_boolean_personal) && parsedict(msgL,good)){
						speakmsg = response_yes(speakername);
						canSpeak=true;
					}else if (parsedict(msgL,question_boolean_personal) && parsedict(msgL,bad)){
						speakmsg = response_no(speakername);
						canSpeak=true;
					}else if (parsedict(msgL,bad)){
						speakmsg = "No, I'm alright!";
						canSpeak=true;
					}else if (parsedict(msgL,good)){
						speakmsg = "Thank you!";
						canSpeak=true;
					}else if (parsedict(msgL,question_general_personal)){
						speakmsg = response(speakername);
						canSpeak=true;
					}else if (parsedict(msgL,greeting)){
						speakmsg = "Hello, "+speakername+"-san.";
						canSpeak=true;
					}
					
					var reacttime = Math.floor((msg.length*28+speakmsg.length*93)+800);
					
					if (canSpeak){
						isprocessing=true;
						setTimeout(function() {
							sinusbot.chatChannel(speakmsg);
							isprocessing=false;
						}, reacttime);
					}
				}
				
			}
			
			
			
			
		});	
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
);





/*
Planned features:
How umaru is feeling (bad to great) depends on if she is being overworked or played/cared with.
store attitude
add latency for multiple requests, implement queue.
Option to call her, which she will respond to the next message.
give delay for reading and typing depending on the string length


*/




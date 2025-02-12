import SwiftUI

struct RideTripView: View {
    @State var from: String = ""
    @State var to: String = ""
    
    @ObservedObject var viewModel: ViewModel
    var body: some View {
        VStack {
            Text("Book Ride")
                .font(.title)
                .padding(.top, 5)
                .padding(.bottom, 15)
            VStack {
                TextField(
                           "from",
                           text: $from
                       )
                TextField(
                           "to",
                           text: $to
                       )
            }
            .padding(.horizontal, 50)
            .textFieldStyle(.roundedBorder)
                .padding(.vertical, 20)
            Divider()
            Spacer()
            NavigationView {
                List {
                    ForEach(viewModel.rides, id: \.id) { ride in
                        NavigationLink(ride.id) {
                            RideListItem(ride: ride)
                        }
                    }
                }
            }
            Spacer()
        }
    }
}

#Preview {
    var model = Model()
    var viewModel = ViewModel(model: model)
    ContentView(selectedTab: 0, viewModel: viewModel)
}
